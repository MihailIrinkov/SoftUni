package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<String, Field>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
              throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        fields.put(fieldName, field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        supplements.add(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = supplements.findByType(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages
                            .NO_SUPPLEMENT_FOUND, supplementType));
        }
        fields.get(fieldName).addSupplement(supplement);
        supplements.remove(supplement);
        return String.format(ConstantMessages
                .SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType,
                            String playerName, String nationality, int strength) {
        if (!playerType.equals("Men") && !playerType.equals("Women")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        Player player;
        switch (playerType) {
            case "Men":
        if (!fields.get(fieldName).getClass().getSimpleName().equals("NaturalGrass")) {
            return String.format(ConstantMessages.FIELD_NOT_SUITABLE);
        } else {
            player = new Men(playerName, nationality, strength);
            fields.get(fieldName).addPlayer(player);
        }
        break;
            case "Women":
                if (!fields.get(fieldName).getClass().getSimpleName().equals("ArtificialTurf")) {
                    return String.format(ConstantMessages.FIELD_NOT_SUITABLE);
                } else {
                    player = new Women(playerName, nationality, strength);
                    fields.get(fieldName).addPlayer(player);
                }
                break;
    }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,
                playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field playersInFieldToDrag = fields.get(fieldName);

//        List<Player> draggedPlayers = new ArrayList<>(playersInFieldToDrag.getPlayers());

        playersInFieldToDrag.drag();
        int count = playersInFieldToDrag.getPlayers().size();

        return String.format(ConstantMessages.PLAYER_DRAG, count);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field fieldStrengthCalculation = fields.get(fieldName);
        int sum = fieldStrengthCalculation.getPlayers().stream()
                .mapToInt(Player::getStrength).sum();

        return String.format(ConstantMessages.STRENGTH_FIELD,
                fieldName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        fields.values().forEach(f->sb.append(f.getInfo())
                .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
