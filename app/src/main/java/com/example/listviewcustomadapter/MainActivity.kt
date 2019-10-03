package com.example.listviewcustomadapter

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayList :ArrayList<Data> = ArrayList()
       // var data  = Data("zero","zeroaudio")

        arrayList.add(Data("zero","zeroaudio"))
        arrayList.add(Data("one","oneaudio"))
        arrayList.add(Data("two","twoaudio"))
        arrayList.add(Data("three","threeaudio"))
        arrayList.add(Data("four","fouraudio"))
        arrayList.add(Data("five","fiveaudio"))
        arrayList.add(Data("six","sixaudio"))
        arrayList.add(Data("seven","sevenaudio"))
        arrayList.add(Data("eight","eightaudio"))
        arrayList.add(Data("nine","nineaudio"))
        arrayList.add(Data("ten","tenaudio"))

        var adapter : 
    }
}
class NumberAdapter : BaseAdapter{
    var arrayList :ArrayList<Data> = ArrayList()
    var context : Context?
    constructor(context: Context, arrayList :ArrayList<Data>){
        this.arrayList = arrayList
        this.context = context
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view :View
        val inflater : LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

        val holder : ViewHolder
        if (p1==null){
            view = inflater.inflate(R.layout.list_item,p2,false)
            holder = ViewHolder()
            holder.text = view.findViewById(R.id.text_view)
            holder.image = view.findViewById(R.id.image_view)
            view.tag=holder
        }else{
        view = p1
            holder= p1.tag as ViewHolder
        }
        val  textValue = holder.text
        textValue?.text=arrayList[p0].textNumber
        val imageValue = holder.image

        var mediaplayer:MediaPlayer?

        imageValue?.setOnClickListener {
        mediaplayer=MediaPlayer.create(context. context?.resources!!.getIdentifier(arrayList[p0].audioNumber,"raw",context?.packageName))
            mediaplayer?.start()
        }
        return view
    }
    private class ViewHolder{
        var text : TextView? =null
        var image :ImageView? = null
    }

    override fun getItem(p0: Int): Any {
    return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getCount(): Int {
        return  arrayList.size
    }

}
