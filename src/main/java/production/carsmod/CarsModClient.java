package production.carsmod;

import net.fabricmc.api.ClientModInitializer;

public class CarsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

    }
    public class CarsModCustomEnitityClient implements  ClientModInitializer{
        @Override
        public void onInitializeClient(){
            CarsModModelLayers.registerModelLayers();
        }
    }
}
