package com.victoria.behavioral.command;

import java.util.List;

// client
public class CommandDemo {

    public static void main(String[] args) {
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();
        Switch lightSwitch = new Switch();

        //Command onCommand = new OnCommand(bedroomLight);
        //lightSwitch.storeAndExecute(onCommand);

        Command toggleCommand = new ToggleCommand(bedroomLight);
        lightSwitch.storeAndExecute(toggleCommand);
        //lightSwitch.storeAndExecute(toggleCommand);
        //lightSwitch.storeAndExecute(toggleCommand);

        List<Light> lights = List.of(kitchenLight, bedroomLight);
        Command allLightsCommand = new AllLightsCommand(lights);
        lightSwitch.storeAndExecute(allLightsCommand);

    }
}
