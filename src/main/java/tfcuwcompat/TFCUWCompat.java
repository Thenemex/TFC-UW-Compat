package tfcuwcompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tfcuwcompat.api.logger.Logger;

@Mod(TFCUWCompat.modID)
public class TFCUWCompat {

    public static final String modID = "tfcuwcompat";
    public static final Logger logger = new Logger(modID);

    public TFCUWCompat() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
        ResourceLocation id = EntityType.getKey(event.getEntity().getType());
        if (id.getNamespace().equals("untamedwilds")) {
            event.setSpawnCancelled(true);
        }
    }
    
}
