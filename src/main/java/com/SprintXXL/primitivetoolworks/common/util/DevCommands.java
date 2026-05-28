package com.SprintXXL.primitivetoolworks.common.util;

import com.SprintXXL.primitivetoolworks.feature.tools.features.modifiers.nbt.ToolModifierSlotNBT;
import com.SprintXXL.primitivetoolworks.feature.tools.util.tools.ToolItemHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class DevCommands extends CommandBase {

    @Override
    public String getName() {
        return "ptwslots";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/ptwslots <amount>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        EntityPlayerMP player = getCommandSenderAsPlayer(sender);

        if (args.length != 1) {
            throw new CommandException("Usage: /ptwslots <amount>");
        }

        int slots = parseInt(args[0], 0);

        ItemStack heldStack = player.getHeldItemMainhand();

        if (ToolItemHelper.isModularTool(heldStack)) {
            ToolModifierSlotNBT.setModifierSlots(heldStack, slots);

            sender.sendMessage(new TextComponentString("Set modifier slots to: " + slots));
        }
    }
}
