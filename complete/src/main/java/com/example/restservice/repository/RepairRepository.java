package com.example.restservice.repository;

import com.example.restservice.models.Repairs;
import com.example.restservice.models.User;

import java.util.ArrayList;
import java.util.List;

public class RepairRepository {

    private final List<Repairs> repairsList = new ArrayList<>();

    public RepairRepository() {
        this.createDummyRepairList();
    }

    /**
     * method to create dummy data for first 5 users
     */
    private void createDummyRepairList() {
        Repairs r = new Repairs();
        r.setId(1);
        r.setStatus("pending");
        r.setmName("Honor 7A");
        r.setDescription("Screen lag issue.");
        r.setUserId(1);
        repairsList.add(r);

        r = new Repairs();
        r.setId(2);
        r.setStatus("approved");
        r.setmName("Redmi");
        r.setDescription("Charge point.");
        r.setUserId(1);
        repairsList.add(r);

        r = new Repairs();
        r.setId(3);
        r.setStatus("approved");
        r.setmName("Samsung");
        r.setDescription("Battery lag.");
        r.setUserId(1);
        repairsList.add(r);

        r = new Repairs();
        r.setId(4);
        r.setStatus("pending");
        r.setmName("Honor 7A");
        r.setDescription("Screen lag issue.");
        r.setUserId(2);
        repairsList.add(r);

        r = new Repairs();
        r.setId(5);
        r.setStatus("approved");
        r.setmName("Redmi");
        r.setDescription("Charge point.");
        r.setUserId(2);
        repairsList.add(r);

        r = new Repairs();
        r.setId(6);
        r.setStatus("approved");
        r.setmName("Samsung");
        r.setDescription("Battery lag.");
        r.setUserId(2);
        repairsList.add(r);


        r = new Repairs();
        r.setId(7);
        r.setStatus("pending");
        r.setmName("Honor 7A");
        r.setDescription("Screen lag issue.");
        r.setUserId(3);
        repairsList.add(r);

        r = new Repairs();
        r.setId(8);
        r.setStatus("approved");
        r.setmName("Redmi");
        r.setDescription("Charge point.");
        r.setUserId(3);
        repairsList.add(r);

        r = new Repairs();
        r.setId(9);
        r.setStatus("approved");
        r.setmName("Samsung");
        r.setDescription("Battery lag.");
        r.setUserId(3);
        repairsList.add(r);
    }

    /**
     * method to get users repair list
     * @param userId
     * @return
     */
    public List<Repairs> getRepairsListForUser(int userId) {
        List<Repairs> usersRepairList = new ArrayList<>();

        for (Repairs r: repairsList) {
            if (r.getUserId() == userId)
                usersRepairList.add(r);
        }

        return usersRepairList;
    }


}

