package pneumaticCraft.common.sensor.pollSensors;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.util.Rectangle;

import pneumaticCraft.api.universalSensor.IBlockAndCoordinatePollSensor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetadataSensor implements IBlockAndCoordinatePollSensor{

    @Override
    public String getSensorPath(){
        return "blockTracker_gpsTool/Block/Metadata";
    }

    @Override
    public int getPollFrequency(){
        return 2;
    }

    @Override
    public boolean needsTextBox(){
        return false;
    }

    @Override
    public List<String> getDescription(){
        List<String> text = new ArrayList<String>();
        text.add(EnumChatFormatting.BLACK + "Emits a redstone of which the strength is the metadata of the block at the location stored in the GPS Tool. Metadata is a variable that is used in many blocks to store a certain state. Some examples in which metadata is used, and therefore this sensor setting can be used for, are plant growth, block facing (e.g. Pistons), lever states, and difference in wool.");
        return text;
    }

    @Override
    public int getRedstoneValue(World world, int x, int y, int z, int sensorRange, String textBoxText, int toolX, int toolY, int toolZ){
        return world.getBlockMetadata(toolX, toolY, toolZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void drawAdditionalInfo(FontRenderer fontRenderer){}

    @Override
    public Rectangle needsSlot(){
        return null;
    }

}