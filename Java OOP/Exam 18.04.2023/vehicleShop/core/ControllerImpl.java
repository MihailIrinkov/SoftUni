package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
    }

    @Override
    public String addWorker(String type, String workerName) {

        Worker worker;

        switch(type) {
            case "FirstShift":
                worker = new FirstShift(workerName);
                break;
            case "SecondShift":
                worker = new SecondShift(workerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        workerRepository.add(worker);
        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle =  new VehicleImpl(vehicleName, strengthRequired);

        vehicleRepository.add(vehicle);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Tool tool = new ToolImpl(power);

        String massage = "";

        if (workerRepository.findByName(workerName) == null) {
            massage = ExceptionMessages.HELPER_DOESNT_EXIST;
        } else {
            workerRepository.findByName(workerName).addTool(tool);
            massage = String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER,
                    power, workerName);
        }

        return massage;
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> selectedWorkers = workerRepository.getWorkers()
                .stream().filter(w -> w.getStrength() > 70)
                .collect(Collectors.toList());
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);


        if (selectedWorkers.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        Shop shop = new ShopImpl();

        int count = 0;
        for (Worker w : selectedWorkers) {
            int toolCountBeforeStart = w.getTools().size();
            shop.make(vehicle, w);
            int toolCountAfterStart = w.getTools().size();

            //count = toolCountBeforeStart - toolCountAfterStart;
            List<Tool> toolList = w.getTools().stream()
                    .filter(t -> t.getPower() > 0).collect(Collectors.toList());
            count = toolCountBeforeStart  - toolList.size();

        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Vehicle %s is ", vehicleName));

        if (vehicle.reached()) {
            sb.append("done. ");
        } else {
         sb.append("not done. ");
        }
        sb.append(String.format("%d tool/s have been unfit while working on it!", count));

        return sb.toString().trim();
    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        int countMadeVehicle = 0;


        for (Vehicle v : vehicleRepository.getWorkers()) {
            if (v.reached()) {
                countMadeVehicle++;
            }
        }
        sb.append(String.format("%d vehicles are ready!", countMadeVehicle));
        sb.append(System.lineSeparator());
        sb.append("Info for workers:");
        sb.append(System.lineSeparator());

        for (Worker w : workerRepository.getWorkers()) {

            List<Tool> toolListFit = w.getTools().stream()
                    .filter(t -> t.getPower() > 0).collect(Collectors.toList());
            int countToolsFitLeft = toolListFit.size();

            sb.append("Name: ");
            sb.append(w.getName());
            sb.append(", ");
            sb.append("Strength: ");
            sb.append(w.getStrength());
            sb.append(System.lineSeparator());
            sb.append(String.format("Tools: %d fit left", countToolsFitLeft));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
