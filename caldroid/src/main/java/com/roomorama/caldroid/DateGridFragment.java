package com.roomorama.caldroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

/**
 * DateGridFragment contains only 1 gridview with 7 columns to display all the
 * dates within a month.
 * <p/>
 * Client must supply gridAdapter and onItemClickListener before the fragment is
 * attached to avoid complex crash due to fragment life cycles.
 *
 * @author thomasdao
 */
public class DateGridFragment extends Fragment {
  private GridView gridView;
  private int themeResource = 0;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    CaldroidFragment parentFragment = (CaldroidFragment) getParentFragment();
    int gridViewRes = parentFragment.getGridViewRes();

    CaldroidGridAdapter gridAdapter = parentFragment.datePagerAdapters
        .get(getArguments().getInt(CaldroidFragment.KEY_GRID_POSITION_IN_ADAPTER));

    themeResource = gridAdapter.getThemeResource();

    if (gridView == null) {
      LayoutInflater localInflater = CaldroidFragment.getThemeInflater(getActivity(),
          inflater, themeResource);
      gridView = (GridView) localInflater.inflate(gridViewRes, container, false);
      gridView.setAdapter(gridAdapter);
    } else {
      ViewGroup parent = (ViewGroup) gridView.getParent();
      if (parent != null) {
        parent.removeView(gridView);
      }
    }

    parentFragment.getCaldroidListener().onGridCreated(gridView);

    return gridView;
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }
}
