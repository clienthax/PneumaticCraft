package pneumaticCraft.common.tileentity;

import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.ForgeDirection;
import pneumaticCraft.api.IHeatExchangerLogic;
import pneumaticCraft.api.PneumaticRegistry;
import pneumaticCraft.api.tileentity.IHeatExchanger;
import pneumaticCraft.common.block.Blockss;
import pneumaticCraft.common.network.GuiSynced;
import pneumaticCraft.lib.PneumaticValues;

public class TileEntityAdvancedLiquidCompressor extends TileEntityLiquidCompressor implements IHeatExchanger{

    @GuiSynced
    private final IHeatExchangerLogic heatExchanger = PneumaticRegistry.getInstance().getHeatExchangerLogic();

    public TileEntityAdvancedLiquidCompressor(){
        super(20, 25, 10000);
        heatExchanger.setThermalCapacity(100);
    }

    @Override
    public IHeatExchangerLogic getHeatExchangerLogic(ForgeDirection side){
        return heatExchanger;
    }

    @Override
    protected void onFuelBurn(int burnedFuel){
        heatExchanger.addHeat(burnedFuel * 2);
    }

    @Override
    public int getBaseProduction(){
        return PneumaticValues.PRODUCTION_ADVANCED_COMPRESSOR;
    }

    @Override
    public int getEfficiency(){
        return MathHelper.clamp_int((int)((625 - heatExchanger.getTemperature()) / 3), 0, 100);//0% efficiency at > 350 degree C, 100% at < 50 degree C.
    }

    @Override
    public String getInventoryName(){

        return Blockss.advancedLiquidCompressor.getUnlocalizedName();
    }
}
