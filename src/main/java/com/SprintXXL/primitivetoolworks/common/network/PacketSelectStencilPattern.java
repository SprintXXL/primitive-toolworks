package com.SprintXXL.primitivetoolworks.common.network;

import com.SprintXXL.primitivetoolworks.feature.tables.stenciltable.containers.ContainerStencilTable;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSelectStencilPattern implements IMessage {

    private String patternID;

    public PacketSelectStencilPattern() {}

    public PacketSelectStencilPattern(String patternID) {
        this.patternID = patternID;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, patternID);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        patternID = ByteBufUtils.readUTF8String(buf);
    }

    public static class Handler implements IMessageHandler<PacketSelectStencilPattern, IMessage> {

        @Override
        public IMessage onMessage(PacketSelectStencilPattern message, MessageContext ctx) {

            EntityPlayerMP player = ctx.getServerHandler().player;

            player.getServerWorld().addScheduledTask(() -> {
                if (player.openContainer instanceof ContainerStencilTable) {
                    ((ContainerStencilTable) player.openContainer)
                            .setSelectedPatternID(message.patternID);
                }
            });

            return null;
        }
    }
}
