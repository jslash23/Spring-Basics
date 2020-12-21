package com.lesson3.DI_CRUD.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "STORAGE")
public class Storage {

    private long id;
    private String[] formatSupported;
    private String storageCountry;
    private long storageSize;

    private File[] files = new File[20];


    @Id
    @SequenceGenerator(name = "STOR_SEQ", sequenceName = "STOR_SEQ_DB", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOR_SEQ")

    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "FORMAT_SUPPORTED")

    public String[] getFormatSupported() {
        return formatSupported;
    }

    public void setFormatSupported(String[] formatSupported) {
        this.formatSupported = formatSupported;
    }

    @Column(name = "STARAGE_COUNTRY")

    public String getStorageCountry() {
        return storageCountry;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    @Column(name = "STORAGE_SIZE")

    public long getStorageSize() {
        return storageSize;
    }


    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", formatSupported=" + Arrays.toString(formatSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }

    public void setFormatSupported(String jpg, String txt) {
    }
}
