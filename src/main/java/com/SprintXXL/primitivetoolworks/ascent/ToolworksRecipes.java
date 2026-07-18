package com.SprintXXL.primitivetoolworks.ascent;

import com.SprintXXL.primitivetoolworks.feature.tables.partbuilder.recipes.RecipePart;
import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers.ContainerStencilTable;
import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.recipes.ModifierApplicationRecipe;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeModularTool;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipePartReplacement;
import com.SprintXXL.primitivetoolworks.feature.tools.recipes.RecipeToolRepair;
import com.sprintxxl.ascentresourcerecipeindex.recipes.AscentRecipeIDs;
import com.sprintxxl.ascentresourcerecipeindex.recipes.shared.Category;
import com.sprintxxl.ascentresourcerecipeindex.recipes.types.crafting.CraftingRecipe;
import com.sprintxxl.ascentresourcerecipeindex.recipes.types.crafting.data.BasicRecipeData;
import com.sprintxxl.ascentresourcerecipeindex.recipes.types.crafting.shape.ShapedRecipe;
import com.sprintxxl.ascentresourcerecipeindex.recipes.types.custom.CustomRecipe;

import java.util.Map;

import static com.sprintxxl.ascentresourcerecipeindex.recipes.reciperesource.RecipeResource.resource;
import static com.sprintxxl.ascentresourcerecipeindex.recipes.registry.AscentRecipeRegistry.register;
import static com.sprintxxl.ascentresourcerecipeindex.recipes.types.crafting.shape.ShapedRecipe.Pattern;
import static com.sprintxxl.ascentresourcerecipeindex.resources.definitions.ResourceCatalog.*;

public final class ToolworksRecipes {

    private ToolworksRecipes() {}

    public static void initToolworksRecipes() {

        register(ASSEMBLE_BLANK_PATTERN);
        register(ASSEMBLE_TOOL_STATION);
        register(ASSEMBLE_PART_BUILDER);
        register(ASSEMBLE_STENCIL_TABLE);
        register(CARVE_PATTERN);
        register(ASSEMBLE_MODULAR_TOOL);
        register(ASSEMBLE_MODULAR_PART);
        register(REPAIR_MODULAR_TOOL);
        register(APPLY_MODULAR_TOOL_MODIFIER);
        register(REPLACE_MODULAR_TOOL_PART);

    }
    
    // CRAFTING \\
    public static final CraftingRecipe ASSEMBLE_BLANK_PATTERN =
            new CraftingRecipe(
                    AscentRecipeIDs.Toolworks.ASSEMBLE_BLANK_PATTERN,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "PP",
                                            "PP"
                                    ),
                                    Map.of(
                                            'P', resource(PAPER)
                                    )
                            ),
                            resource(BLANK_PATTERN)
                    )
            );
    public static final CraftingRecipe ASSEMBLE_TOOL_STATION =
            new CraftingRecipe(
                    AscentRecipeIDs.Toolworks.ASSEMBLE_TOOL_STATION,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "PPP",
                                            "BCB",
                                            "PPP"
                                    ),
                                    Map.of(
                                            'P', resource(OAK_PLANKS),
                                            'B', resource(BLANK_PATTERN),
                                            'C', resource(CRAFTING_TABLE)
                                    )
                            ),
                            resource(TOOL_STATION)
                    )
            );
    public static final CraftingRecipe ASSEMBLE_PART_BUILDER =
            new CraftingRecipe(
                    AscentRecipeIDs.Toolworks.ASSEMBLE_PART_BUILDER,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "LLL",
                                            "BCB",
                                            "LLL"
                                    ),
                                    Map.of(
                                            'L', resource(OAK_LOG),
                                            'B', resource(BLANK_PATTERN),
                                            'C', resource(CRAFTING_TABLE)
                                    )
                            ),
                            resource(PART_BUILDER)
                    )
            );
    public static final CraftingRecipe ASSEMBLE_STENCIL_TABLE =
            new CraftingRecipe(
                    AscentRecipeIDs.Toolworks.ASSEMBLE_STENCIL_TABLE,
                    Category.ASSEMBLY,
                    new BasicRecipeData(
                            new ShapedRecipe(
                                    Pattern(
                                            "LLL",
                                            "BCB",
                                            "LLL"
                                    ),
                                    Map.of(
                                            'L', resource(BIRCH_LOG),
                                            'B', resource(BLANK_PATTERN),
                                            'C', resource(CRAFTING_TABLE)
                                    )
                            ),
                            resource(STENCIL_TABLE)
                    )
            );

    // CUSTOM \\
    public static final CustomRecipe CARVE_PATTERN =
            new CustomRecipe(
                    AscentRecipeIDs.Toolworks.CARVE_PATTERN,
                    Category.PROCESSING,
                    ContainerStencilTable.class
            );
    public static final CustomRecipe ASSEMBLE_MODULAR_TOOL =
            new CustomRecipe(
                    AscentRecipeIDs.Toolworks.ASSEMBLE_MODULAR_TOOL,
                    Category.ASSEMBLY,
                    RecipeModularTool.class
            );
    public static final CustomRecipe ASSEMBLE_MODULAR_PART =
            new CustomRecipe(
                    AscentRecipeIDs.Toolworks.ASSEMBLE_MODULAR_PART,
                    Category.ASSEMBLY,
                    RecipePart.class
            );
    public static final CustomRecipe REPAIR_MODULAR_TOOL =
            new CustomRecipe(
                    AscentRecipeIDs.Toolworks.REPAIR_MODULAR_TOOL,
                    Category.ASSEMBLY,
                    RecipeToolRepair.class
            );
    public static final CustomRecipe APPLY_MODULAR_TOOL_MODIFIER =
            new CustomRecipe(
                    AscentRecipeIDs.Toolworks.APPLY_MODULAR_TOOL_MODIFIER,
                    Category.ASSEMBLY,
                    ModifierApplicationRecipe.class
            );
    public static final CustomRecipe REPLACE_MODULAR_TOOL_PART =
            new CustomRecipe(
                    AscentRecipeIDs.Toolworks.REPLACE_MODULAR_TOOL_PART,
                    Category.ASSEMBLY,
                    RecipePartReplacement.class
            );
}
