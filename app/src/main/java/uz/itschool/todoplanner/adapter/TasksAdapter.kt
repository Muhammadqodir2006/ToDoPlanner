package uz.itschool.todoplanner.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import de.hdodenhof.circleimageview.CircleImageView
import uz.itschool.todoplanner.R
import uz.itschool.todoplanner.database.AppDatabase

class TasksAdapter(context: Context) : RecyclerView.Adapter<TasksAdapter.MyHolder>() {
    val list = AppDatabase.getInstance(context).getTaskDao().getUndone().toMutableList()

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val line : CardView = itemView.findViewById(R.id.tasks_item_line_cv)
        val taskText : TextView = itemView.findViewById(R.id.tasks_item_text)
        val checkBTN : MaterialButton = itemView.findViewById(R.id.tasks_item_check_mbtn)
        val categoryTV : TextView = itemView.findViewById(R.id.tasks_item_category_text)
        val urgentIV : ImageView = itemView.findViewById(R.id.tasks_item_urgent_iv)
        val importantIV : ImageView = itemView.findViewById(R.id.tasks_item_important_iv)
        val priorityTV : TextView = itemView.findViewById(R.id.tasks_item_priority_tv)
        val priorityParent : MaterialCardView = itemView.findViewById(R.id.tasks_item_priority_parent_mcv)
        val editCIV : CircleImageView = itemView.findViewById(R.id.tasks_item_edit_civ)
        val extendIV : ImageView = itemView.findViewById(R.id.tasks_item_extend_iv)
        val categoryCircle : MaterialCardView = itemView.findViewById(R.id.tasks_item_colored_circle_mcv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return  MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.tasks_task_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        if (position == 0) holder.line.visibility = View.INVISIBLE
        val task = list[position]
        holder.taskText.text = task.task
        holder.checkBTN.setOnClickListener {
            // TODO: set listener
        }
        // TODO: set
        if (task.category != 0){
            var category = "Home"
            holder.categoryCircle.setCardBackgroundColor(R.color.green_50)
            if (task.category == 2) {
                category = "Work"
                holder.categoryCircle.setCardBackgroundColor(R.color.blue_50)
            }
            holder.categoryTV.text = category
        }
        if (!task.urgent) holder.urgentIV.visibility = View.GONE
        if (!task.important) holder.importantIV.visibility = View.GONE

        if (task.priority == 0){
            holder.priorityParent.visibility = View.GONE
        }else{
            var pr = "High priority"
            if (task.priority == 2) pr = "Very high priority"
            holder.priorityTV.text = pr
        }
        holder.editCIV.setOnClickListener {
            //TODO: set listener
        }
        holder.itemView.setOnClickListener {
            // TODO: Extend on tap
        }
        if (task.subtasks.isEmpty()) holder.extendIV.visibility = View.GONE
    }
}