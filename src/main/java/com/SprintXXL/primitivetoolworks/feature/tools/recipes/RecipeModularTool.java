package com.SprintXXL.primitivetoolworks.feature.tools.recipes;

import com.SprintXXL.primitivetoolworks.feature.tools.features.levels.nbt.ToolLevelNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
import com.SprintXXL.primitivetoolworks.library.parts.Part;
import com.SprintXXL.primitivetoolworks.library.parts.nbt.PartNBT;
import com.SprintXXL.primitivetoolworks.library.parts.registry.PartRegistry;
import com.SprintXXL.primitivetoolworks.library.parts.stats.MainPartStats;
import com.SprintXXL.primitivetoolworks.common.util.RecipeHelper;
import com.SprintXXL.primitivetoolworks.common.registry.ModItems;
import com.SprintXXL.primitivetoolworks.feature.tools.nbt.ToolNBT;
import com.SprintXXL.primitivetoolworks.feature.tables.toolworkbench.ToolStationTier;
import com.SprintXXL.primitivetoolworks.library.tooltypes.ToolType;
import com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ToolTypeIDs.*;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.primitivetoolworks.library.tooltypes.definitions.ToolTypeIDs.*;

public class RecipeModularTool {

    private static final int MAIN_SLOT = 1;
    private static final int EXTRA_SLOT = 4;
    private static final int HANDLE_SLOT = 7;

    private final ToolStationTier stationTier;

    public RecipeModularTool(ToolStationTier stationTier) {
        this.stationTier = stationTier;
    }

    public boolean matches(InventoryCrafting craftMatrix) {

        if (!RecipeHelper.matchesCraftMatrix(craftMatrix)) {
            return false;
        }

        if (!areAllOtherSlotsEmpty(craftMatrix)) {
            return false;
        }

        ItemStack mainStack = getMainStack(craftMatrix);
        ItemStack extraStack = getExtraStack(craftMatrix);
        ItemStack handleStack = getHandleStack(craftMatrix);

        if (!areRequiredSlotsFilled(mainStack, extraStack, handleStack)) {
            return false;
        }

        if (!areStacksToolParts(mainStack, extraStack, handleStack)) {
            return false;
        }

        return doPartsFormValidTool(mainStack, extraStack, handleStack);

    }

    public ItemStack getOutput(InventoryCrafting craftMatrix) {

        ItemStack mainStack = getMainStack(craftMatrix);
        ItemStack extraStack = getExtraStack(craftMatrix);
        ItemStack handleStack = getHandleStack(craftMatrix);

        ToolType toolType = getToolType(mainStack);

        if (toolType == null) {
            return ItemStack.EMPTY;
        }

        ToolStationTier requiredTier = toolType.getRequiredStationTier();

        if (!stationTier.canCraft(requiredTier)) {
            return ItemStack.EMPTY;
        }

        ItemStack result = createOutputStack(toolType);

        ToolNBT.setToolType(result, toolType);

        ToolNBT.setMainMaterial(result, PartNBT.getMaterial(mainStack));
        ToolNBT.setMainPart(result, PartNBT.getPartType(mainStack));

        ToolNBT.setExtraMaterial(result, PartNBT.getMaterial(extraStack));
        ToolNBT.setExtraPart(result, PartNBT.getPartType(extraStack));

        ToolNBT.setHandleMaterial(result, PartNBT.getMaterial(handleStack));
        ToolNBT.setHandlePart(result, PartNBT.getPartType(handleStack));

        ToolModifierSlotNBT.setModifierSlots(result, 0);

        ToolLevelNBT.setLevel(result, 1);
        ToolLevelNBT.setXP(result, 0);
        ToolLevelNBT.setTotalXP(result, 0);

        return result;
    }

    public void consumeIngredients(InventoryCrafting craftMatrix) {

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {

            ItemStack stack = craftMatrix.getStackInSlot(i);

            if (!stack.isEmpty()) {
                stack.shrink(1);
            }
        }
    }

    private static ToolType getToolType(ItemStack mainStack) {

        String mainPartID = PartNBT.getPartType(mainStack);

        Part mainPart = PartRegistry.getPart(mainPartID);

        if (mainPart == null) {
            return null;
        }

        MainPartStats mainStats = (MainPartStats) mainPart.getPartStats();

        return mainStats.getToolType();
    }

    private static boolean areStacksToolParts(ItemStack mainStack, ItemStack extraStack, ItemStack handleStack) {

        if (mainStack.getItem() != ModItems.PART || extraStack.getItem() != ModItems.PART || handleStack.getItem() != ModItems.PART) {
            return false;
        }

        return true;
    }

    private static boolean areRequiredSlotsFilled(ItemStack mainStack, ItemStack extraStack, ItemStack handleStack) {

        return !mainStack.isEmpty()
        && !extraStack.isEmpty()
        && !handleStack.isEmpty();
    }

    private static boolean areAllOtherSlotsEmpty(InventoryCrafting craftMatrix) {

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (i != MAIN_SLOT && i != EXTRA_SLOT && i != HANDLE_SLOT) {
                if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    private static ItemStack createOutputStack(ToolType toolType) {

        switch (toolType.getID()) {

            case SWORD:
                return new ItemStack(ModItems.MODULAR_SWORD);
            case PICKAXE:
                return new ItemStack(ModItems.MODULAR_PICKAXE);
            case AXE:
                return new ItemStack(ModItems.MODULAR_AXE);
            case SHOVEL:
                return new ItemStack(ModItems.MODULAR_SHOVEL);
            case HOE:
                return new ItemStack(ModItems.MODULAR_HOE);
            case HAMMER:
                return new ItemStack(ModItems.MODULAR_HAMMER);
            default:
                return ItemStack.EMPTY;
        }
    }

    private static boolean doPartsFormValidTool(ItemStack mainStack, ItemStack extraStack, ItemStack handleStack) {

        ToolType toolType = getToolType(mainStack);

        if (toolType == null) {
            return false;
        }

        String expectedMainPart = toolType.getDefaultMainPart();
        String expectedExtraPart = toolType.getDefaultExtraPart();
        String expectedHandlePart = toolType.getDefaultHandlePart();

        return expectedMainPart.equals(PartNBT.getPartType(mainStack))
                && expectedExtraPart.equals(PartNBT.getPartType(extraStack))
                && expectedHandlePart.equals(PartNBT.getPartType(handleStack));
    }

    private static ItemStack getMainStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(MAIN_SLOT);
    }
    private static ItemStack getExtraStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(EXTRA_SLOT);
    }
    private static ItemStack getHandleStack(InventoryCrafting craftMatrix) {
        return craftMatrix.getStackInSlot(HANDLE_SLOT);
    }
}
