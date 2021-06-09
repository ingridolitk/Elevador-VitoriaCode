import android.content.Context
import android.widget.EditText
import android.widget.Toast

class Elevador {
    var qtdPessoa = ArrayList<Pessoa>()
    var entrou = false

    fun entrarElevador(pessoa: Pessoa) {
        qtdPessoa.add(pessoa)
    }

    fun totalPessoas(): Int {
        return qtdPessoa.size
    }

    fun sairElevador(pessoa: Pessoa) {
        qtdPessoa.remove(pessoa)
    }
    fun validarAndar(opc: EditText, context: Context): Boolean {
        var tudoOk = true
        if (opc.text.toString().isEmpty()) {
            Toast.makeText(context, "Selecione o andar", Toast.LENGTH_LONG).show()
            tudoOk = false
        } else if (tudoOk && opc.text.toString().toInt() > 5) {
            Toast.makeText(context, "O andar informado não existe", Toast.LENGTH_SHORT).show()
            tudoOk = false
        }
        return tudoOk
    }

    fun entrarNoElevador(opc: EditText, context: Context): Boolean {
        var tudoOk = true
        if (opc.text.toString().isEmpty()) {
            Toast.makeText(context, "Selecione o andar", Toast.LENGTH_LONG).show()
            tudoOk = false
        } else if (tudoOk && this.totalPessoas() > 9) {
            Toast.makeText(context, "Elevador lotado. Aguarde!", Toast.LENGTH_LONG).show()
            tudoOk = false
        }

        return tudoOk
    }

    fun sairElevador(opc: EditText, context: Context): Boolean {
        var tudoOk = true
        if (opc.text.toString().isEmpty()) {
            Toast.makeText(context, "Selecione o andar", Toast.LENGTH_LONG).show()
            tudoOk = false
        } else if (tudoOk && this.totalPessoas() == 0) {
            Toast.makeText(context, "Não tem ninguém para sair do elevador!", Toast.LENGTH_LONG)
                .show()
            tudoOk = false
        }
        return tudoOk
    }
}