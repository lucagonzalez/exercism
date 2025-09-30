class Badge {
    public String print(Integer id, String name, String department) {
        StringBuilder printLine = new StringBuilder();

        printLine.append(String.format("%s - ", name));

        if (id != null) {
            printLine.insert(0, String.format("[%s] - ", id));
        }

        printLine.append(String.format("%s", department == null ? "OWNER" : department.toUpperCase()));

        return printLine.toString();
    }
}
