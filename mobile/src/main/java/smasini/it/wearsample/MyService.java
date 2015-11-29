package smasini.it.wearsample;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class MyService extends WearableListenerService {

    public MyService() {
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        super.onDataChanged(dataEvents);
        for(DataEvent dataEvent : dataEvents){
            if(dataEvent.getType() == DataEvent.TYPE_CHANGED){
                DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
                String path = dataEvent.getDataItem().getUri().getPath();
                if(path.equals("7step-counter")){
                    int steps = dataMap.getInt("step-count");
                    long time = dataMap.getLong("timestamp");
                }
            }
        }
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        if(messageEvent.getPath().equals("/path/message")){
            //do something with bute array from messageEvent.getData();
        }

    }
}
