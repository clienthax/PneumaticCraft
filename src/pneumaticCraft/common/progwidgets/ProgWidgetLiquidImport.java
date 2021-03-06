package pneumaticCraft.common.progwidgets;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import pneumaticCraft.common.ai.DroneAILiquidImport;
import pneumaticCraft.common.entity.living.EntityDrone;
import pneumaticCraft.common.item.ItemPlasticPlants;
import pneumaticCraft.lib.Textures;

public class ProgWidgetLiquidImport extends ProgWidgetInventoryBase implements ILiquidFiltered{

    @Override
    public String getWidgetString(){
        return "liquidImport";
    }

    @Override
    public String getGuiTabText(){
        return "bla";
    }

    @Override
    public int getGuiTabColor(){
        return 0xFFFFFFFF;
    }

    @Override
    protected ResourceLocation getTexture(){
        return Textures.PROG_WIDGET_LIQUID_IM;
    }

    @Override
    public Class<? extends IProgWidget>[] getParameters(){
        return new Class[]{ProgWidgetArea.class, ProgWidgetLiquidFilter.class};
    }

    @Override
    public boolean isFluidValid(Fluid fluid){
        return ProgWidgetLiquidFilter.isLiquidValid(fluid, this, 1);
    }

    @Override
    public EntityAIBase getWidgetAI(EntityDrone drone, IProgWidget widget){
        return new DroneAILiquidImport(drone, drone.getSpeed(), (ProgWidgetAreaItemBase)widget);
    }

    @Override
    public int getCraftingColorIndex(){
        return ItemPlasticPlants.RAIN_PLANT_DAMAGE;
    }
}
