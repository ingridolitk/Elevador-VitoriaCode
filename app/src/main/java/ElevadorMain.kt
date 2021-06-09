import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import com.ingrid.elevador.R

class Pessoa {
    var list = mutableListOf<Any>()
    fun selecionarAndar(opcao: Int): MutableList<Any> {
        list.add(true)
        list.add("Andar Selecionado. Entre no elevador")
        return list
    }

    fun validaAndar(opc: EditText, context: Context) {
        var andarAtual = opc
    }
}