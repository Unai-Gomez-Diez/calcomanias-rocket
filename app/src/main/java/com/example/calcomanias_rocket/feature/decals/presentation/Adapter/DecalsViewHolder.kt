

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.calcomanias_rocket.app.extensions.loadurl
import com.example.calcomanias_rocket.databinding.ViewItemDecalBinding
import com.example.calcomanias_rocket.feature.decals.domain.Decal

class DecalsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val itemDecal = ViewItemDecalBinding.bind(view)

    fun bind(decal: Decal, onClick: (String)->Unit){
        itemDecal.apply {
            imagen.loadurl(decal.img)
            description.text = decal.description
        }
    }
}