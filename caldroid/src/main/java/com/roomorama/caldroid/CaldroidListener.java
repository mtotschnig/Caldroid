package com.roomorama.caldroid;

import android.widget.GridView;

/**
 * CaldroidListener inform when user clicks on a valid date (not within disabled
 * dates, and valid between min/max dates)
 * <p/>
 * The method onChangeMonth is optional, user can always override this to listen
 * to month change event
 *
 * @author thomasdao
 */
public abstract class CaldroidListener {


    /**
     * Inform client that calendar has changed month
     *
     * @param month
     * @param year
     */
    public void onChangeMonth(int month, int year) {
        // Do nothing
    }

    ;


    /**
     * Inform client that CaldroidFragment view has been created and views are
     * no longer null. Useful for customization of button and text views
     */
    public void onCaldroidViewCreated() {
        // Do nothing
    }

    public void onGridCreated(GridView gridView) {
        // Do nothing
    }
}
