package gateways;

import entities.User;
import java.io.*;
import java.util.*;

public class AccountLoginGateway {
    private final File csvFile;

    private final Map<String, Integer> headers;

    private final Map<Integer, String> accounts;

    /**
     * Create an account gateway that uses csv files as persistent storage.
     *
     * @param csvPath Path to the csv file holding account data
     * @throws IOException If the given csv file cannot be accessed
     */
    public AccountLoginGateway(String csvPath) throws IOException {

        csvFile = new File(csvPath);
        headers = new LinkedHashMap<>();

        headers.put("account_id", 0);
        headers.put("username", 1);
        headers.put("password", 2);

        accounts = new HashMap<>();

        if (csvFile.length() == 0) {

            save();

        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {

                String[] col = row.split(",");
                Integer accountId = Integer.valueOf(col[headers.get("account_id")]);
                accounts.put(accountId, row);

            }

            reader.close();

        }

    }

    private void save() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
        writer.write(String.join(",", headers.keySet()));
        writer.newLine();

        for (String line : accounts.values()) {

            writer.write(line);
            writer.newLine();

        }

        writer.close();

    }

    private String generateRow(User account) {

        String[] col = {
                String.valueOf(account.getAccountID()),
                account.getUsername(),
                account.getPassword(),
        };

        return String.join(",", col);
    }

    /**
     * find user by id
     */
    public User findById(int id) {

        if (accounts.containsKey(id)) {

            String[] col = accounts.get(id).split(",");

            String username = col[headers.get("username")];
            String password = col[headers.get("password")];

            return new User(username, password, id);
        }

        return null;
    }

    /**
     * find user by username
     */
    public boolean findByUsername(String username) {
        for (Integer accountId : accounts.keySet()) {
            User account = findById(accountId);
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * find user by username
     */
    public int getUserId(String username) {
        for (Integer accountId : accounts.keySet()) {
            User account = findById(accountId);
            if (account.getUsername().equals(username)) {
                return accountId;
            }
        }
        return -1;
    }

    /**
     * find user by username
     */
    public boolean validPassword(String username, String password) {
        for (Integer accountId : accounts.keySet()) {
            User account = findById(accountId);
            if (account.getUsername().equals(username) & account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates user account
     */
    public boolean updateAccount(User account) {

        String backup = accounts.get(account.getAccountID());

        accounts.put(account.getAccountID(), generateRow(account));

        try {

            save();

        } catch (IOException e) {

            if (backup != null) accounts.put(account.getAccountID(), backup);
            return false;

        }

        return true;
    }

    /**
     * generates valid id for new user
     */
    public int generateValidId() {
        if (accounts.isEmpty()) return 0;
        return Collections.max(accounts.keySet()) + 1;
    }

}
