package com.example.petsapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {
    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_PETS = "pets";

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}

    public static final class PetEntry implements BaseColumns{

        // Name of database table for pets
        public final static String TABLE_NAME="pets";
        //Unique ID number for the pet (only for use in the database table)
        //Type INTEGER
        public static final String  _ID=BaseColumns._ID;

        // Name of the pet
        //Type TEXT
        public static final String COLUMN_PET_NAME="name";

        //Breed of the pet
        //Type TEXT
        public static final String COLUMN_PET_BREED="breed";

        //Gender  of the pet
        //Type INTEGER
        public static final String COLUMN_PET_GENDER="gender";

        //weight of the pet
        //Type INTEGER
        public static final String COLUMN_PET_WEIGHT="weight";

        //Possible values for the gender of the pet
        public static final int GENDER_UNKNOWN=0;
         public static final int GENDER_MALE=1;
         public static final int GENDER_FEMALE=2;

        public static final Uri CONTENT_URI =Uri.withAppendedPath(BASE_CONTENT_URI,PATH_PETS);
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }
        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;
    }


}
