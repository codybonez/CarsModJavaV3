package production.carsmod.items;

import net.fabricmc.api.ModInitializer;

public class CarsModItems implements ModInitializer {
    @Override
    public void onInitialize() {
        CarItem.initialize();
    }
}
