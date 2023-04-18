package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop{
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();


            Tool currentTool = tools.iterator().next();

        while (worker.canWork() && vehicle.getStrengthRequired() > 0
        && currentTool.getPower() > 0) {

            worker.working();
            vehicle.making();

            if (currentTool.isUnfit() && tools.iterator().hasNext()) {
                tools.remove(currentTool);
                currentTool = tools.iterator().next();
            }

        }
    }
}
