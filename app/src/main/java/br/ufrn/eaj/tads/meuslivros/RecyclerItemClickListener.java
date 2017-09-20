package br.ufrn.eaj.tads.meuslivros;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Aluno on 20/09/2017.
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    OnItemClickListener mListener;
    GestureDetector mGestureDetector;


    public interface OnItemClickListener{
        void clickinho(View view, int position);
        void clickao(View view, int position);
    }
    public RecyclerItemClickListener(Context context, final RecyclerView view, OnItemClickListener listener){
        mListener = listener;
        mGestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e){
                super.onSingleTapUp(e);
                View childView =  view.findChildViewUnder(e.getX(),e.getY());
                if(childView != null && mListener != null){
                    mListener.clickinho(childView,view.getChildAdapterPosition(childView));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                View childView = view.findChildViewUnder(e.getX(),e.getY());
                if(childView != null && mListener != null){
                    mListener.clickao(childView,view.getChildAdapterPosition(childView));
                }
            }
        });




    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
