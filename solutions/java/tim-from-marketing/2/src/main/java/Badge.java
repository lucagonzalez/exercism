class Badge {
    public String print(Integer id, String name, String department) {
        StringBuilder printLine = new StringBuilder();

        printLine.append(name.concat(" - "));

        if (id != null) {
            String idStr = "[".concat(String.valueOf(id)).concat("] - ");

            printLine.insert(0, idStr);
        }

        String departmentStr = department == null ? "OWNER" : department.toUpperCase();

        printLine.append(departmentStr);

        return printLine.toString();
    }
}
