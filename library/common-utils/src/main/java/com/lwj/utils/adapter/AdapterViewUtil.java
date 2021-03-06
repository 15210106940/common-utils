package com.lwj.utils.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by lwj on 16/3/15.
 * Des: AdapterViewUtil
 */
public class AdapterViewUtil {

    public static <T> T getItemModel(ListView listView, int i) {

        if (listView == null) {
            return null;
        }
        if (i < 0) {
            return null;
        }
        int headerCount = listView.getHeaderViewsCount();
        if (i >= headerCount) {
            return (T) listView.getAdapter().getItem(i);
        }
        return null;
    }

    /**
     * 判断 listview  是否滑动到顶部了
     *
     * @param listView
     * @return
     */
    public static boolean isAdapterViewAttach(AbsListView listView) {

        if (listView != null && listView.getChildCount() > 0) {
            if (listView.getChildAt(0).getTop() < 0) {
                return false;
            }

        }
        return true;
    }

    /**
     * 设置 listive 全部展开
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {
            int totalHeight = 0;

            for (int params = 0; params < listAdapter.getCount(); ++params) {
                View listItem = listAdapter.getView(params, (View) null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }

            ViewGroup.LayoutParams var5 = listView.getLayoutParams();
            var5.height = totalHeight + listView.getDividerHeight() * (listAdapter.getCount() - 1);
            listView.setLayoutParams(var5);
        }
    }
}
