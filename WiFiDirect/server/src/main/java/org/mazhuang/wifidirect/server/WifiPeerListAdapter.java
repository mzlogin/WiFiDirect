package org.mazhuang.wifidirect.server;

import android.net.wifi.p2p.WifiP2pDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WifiPeerListAdapter extends BaseAdapter {

    private List<WifiP2pDevice> mData = new ArrayList<>();

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peers_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mName.setText(mData.get(position).deviceName);

        return convertView;
    }

    public void setData(Collection<WifiP2pDevice> data) {
        if (!data.equals(mData)) {
            mData.clear();
            mData.addAll(data);

            notifyDataSetChanged();
        }
    }

    private static class ViewHolder {
        TextView mName;

        ViewHolder(View root) {
            mName = root.findViewById(R.id.name);
        }
    }
}
