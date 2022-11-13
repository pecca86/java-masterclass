module pekka.common {
    requires java.sql;

    exports pekka.common to java.sql.rowset, java.base, pekka.db; // now java.sql.rowset can access our package
    opens pekka.common to java.sql;
}