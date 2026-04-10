package tfcuwcompat;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tfcuwcompat.api.logger.Logger;

@Mod(TFCUWCompat.modID)
public class TFCUWCompat {

    public static final String modID = "tfcuwcompat";
    public static final Logger logger = new Logger(modID);

    public TFCUWCompat() {
        MinecraftForge.EVENT_BUS.register(this);
        logger.info(""); // idk what you put when you
    }

    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        // block all the Untamed Wilds spawns
        if (event.getEntity() != null && event.getEntity().getType().getRegistryName() != null) {
            if ("untamedwilds".equals(event.getEntity().getType().getRegistryName().getNamespace())) {
                event.setResult(Event.Result.DENY);
            }
        }
    }
    
}
