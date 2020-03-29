package com.connectis.manager;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Database {

    private Map<DomainUserKey, Password> domainUserKeyPasswordMap;

    public Database() {
        domainUserKeyPasswordMap = new TreeMap<>();
    }

//    public void addDatabaseEntry(String domainAddress, String userLogin, String password) {
//
//        for (Map.Entry<DomainUserKey, Password> entry : domainUserKeyPasswordMap.entrySet()) {
//            if (entry.getKey().getUser().getLogin().equals(userLogin) &&
//                    entry.getKey().getDomain().getAddress().equals(domainAddress)) {
//                System.out.println("This user already exists. Please try different one.");
//            }
//        }
//        domainUserKeyPasswordMap.put(new DomainUserKey(new Domain(domainAddress),
//                        new User(userLogin)),
//                new Password(password));
//    }

    public void addDatabaseEntry(String domainAddress, String userLogin, String password) {

        domainUserKeyPasswordMap.put(new DomainUserKey(
                                                        new Domain(domainAddress),
                                                        new User(userLogin)),
                                    new Password(password));
    }


    public boolean checkIfEntryExist(String domainAddress, String userLogin) {
        for (Map.Entry<DomainUserKey, Password> entry : domainUserKeyPasswordMap.entrySet()) {
            if (entry.getKey().getUser().getLogin().equals(userLogin) &&
                    entry.getKey().getDomain().getAddress().equals(domainAddress)) {
                return true;
            }
        }
        return false;
    }



//    public void changePassword() {
//
//    }

    public Map<DomainUserKey, Password> getDomainUserKeyPasswordMap() {
        return domainUserKeyPasswordMap;
    }

/////////// SPYTAC BARTKA CZY TO JEST DOBRE UZYCIE OPTIONALA
    public Optional<String> getDomainUserPassword(String domainAddress, String userLogin) {

        DomainUserKey domainUserKey = new DomainUserKey(new Domain(domainAddress),
                                                        new User(userLogin));

        return Optional.ofNullable(domainUserKeyPasswordMap.get(domainUserKey).getPassword());

//        if (domainUserKeyPasswordMap.containsKey(domainUserKey)) {
//            return Optional.of(domainUserKeyPasswordMap.get(domainUserKey));
//        } else {
//            return Optional.empty();
//        }

//        return Optional.empty(); // spytac Bartka czy to jest dobre uzycie ???
    }

//    /////////// SPYTAC BARTKA CZY TO JEST DOBRE UZYCIE OPTIONALA
//    public Optional<Password> getDomainUserPassword(String domainAddress, String userLogin) {
//
//        for (Map.Entry<DomainUserKey, Password> entry : domainUserKeyPasswordMap.entrySet()) {
//            if (entry.getKey().getUser().getLogin().equals(userLogin) &&
//                    entry.getKey().getDomain().getAddress().equals(domainAddress)) {
//                return Optional.ofNullable(entry.getValue());  // spytac Bartka czy to jest dobre uzycie ???
//            }
//        }
//        return Optional.empty(); // spytac Bartka czy to jest dobre uzycie ???
//    }


    @Override
    public String toString() {
        return "CarRepository{" +
                "domainUserKeyPasswordMap=" + domainUserKeyPasswordMap +
                '}';
    }
}
