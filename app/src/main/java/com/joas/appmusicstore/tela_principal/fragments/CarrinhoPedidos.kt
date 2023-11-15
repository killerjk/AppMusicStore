package com.joas.appmusicstore.tela_principal.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivityCarrinhoPedidosBinding
import com.joas.appmusicstore.tela_categoria_produto.AdicionarProduto

class CarrinhoPedidos : AppCompatActivity() {

    private lateinit var binding : ActivityCarrinhoPedidosBinding

    //Set quantidade dos produtos
    private var qntClaBb: Int = CarrinhoProdutos.qntClaBb
    private var qntClaEb: Int = CarrinhoProdutos.qntClaEb
    private var qntTromBb: Int = CarrinhoProdutos.qntTromBb
    private var qntTromC: Int = CarrinhoProdutos.qntTromC
    private var qntSaxAlto: Int = CarrinhoProdutos.qntSaxAlto
    private var qntSaxTenor: Int = CarrinhoProdutos.qntSaxTenor
    private var qntVioRol: Int = CarrinhoProdutos.qntVioRol
    private var qntVioLut: Int = CarrinhoProdutos.qntVioLut
    private var qntPiaKaw: Int = CarrinhoProdutos.qntPiaKaw
    private var qntPiaTok: Int = CarrinhoProdutos.qntPiaTok

    //Set valores produtos
    private val valClaBb: Float = 4995f
    private val valClaEb: Float = 20035f
    private val valTromBb: Float = 23300f
    private val valTromC: Float = 42683f
    private val valSaxAlto: Float = 6050f
    private val valSaxTenor: Float = 8200f
    private val valVioRol: Float = 2100f
    private val valVioLut: Float = 3200f
    private val valPiaKaw: Float = 453340f
    private val valPiaTok: Float = 12900f

    //Set valor total
    private var valorTotal: Float = CarrinhoProdutos.valortotal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarrinhoPedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarCarrinhoPedidos
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Carrinho - Produtos")

        //Exibindo produtos adicionados
        val claBbMostrar = AdicionarProduto.claBbMostrar
        val claEbMostrar = AdicionarProduto.claEbMostrar
        val tromBbMostrar = AdicionarProduto.tromBbMostrar
        val tromCMostrar = AdicionarProduto.tromCMostrar
        val saxAltoMostrar = AdicionarProduto.saxAltoMostrar
        val saxTenorMostrar = AdicionarProduto.saxTenorMostrar
        val vioRolMostrar = AdicionarProduto.vioRolMostrar
        val vioLutMostrar = AdicionarProduto.vioLutMostrar
        val piaKawMostrar = AdicionarProduto.piaKawMostrar
        val piaTokMostrar = AdicionarProduto.piaTokMostrar

        if (claBbMostrar){
            binding.ClaBb.visibility = View.VISIBLE
            binding.txtQuantidadeClaBb.text = qntClaBb.toString()
        } else {
            binding.ClaBb.visibility = View.GONE
        }

        if (claEbMostrar){
            binding.ClaEb.visibility = View.VISIBLE
            binding.txtQuantidadeClaEb.text = qntClaEb.toString()
        } else {
            binding.ClaEb.visibility = View.GONE
        }

        if (tromBbMostrar){
            binding.TromBb.visibility = View.VISIBLE
            binding.txtQuantidadeTromBb.text = qntTromBb.toString()
        } else {
            binding.TromBb.visibility = View.GONE
        }

        if (tromCMostrar){
            binding.TromC.visibility = View.VISIBLE
            binding.txtQuantidadeTromC.text = qntTromC.toString()
        } else {
            binding.TromC.visibility = View.GONE
        }

        if (saxAltoMostrar){
            binding.SaxAlto.visibility = View.VISIBLE
            binding.txtQuantidadeSaxAlto.text = qntSaxAlto.toString()
        } else {
            binding.SaxAlto.visibility = View.GONE
        }

        if (saxTenorMostrar){
            binding.SaxTenor.visibility = View.VISIBLE
            binding.txtQuantidadeSaxTenor.text = qntSaxTenor.toString()
        } else {
            binding.SaxTenor.visibility = View.GONE
        }

        if (vioRolMostrar){
            binding.VioRol.visibility = View.VISIBLE
            binding.txtQuantidadeVioRol.text = qntVioRol.toString()
        } else {
            binding.VioRol.visibility = View.GONE
        }

        if (vioLutMostrar){
            binding.VioLut.visibility = View.VISIBLE
            binding.txtQuantidadeVioLut.text = qntVioLut.toString()
        } else {
            binding.VioLut.visibility = View.GONE
        }

        if (piaKawMostrar){
            binding.PiaKaw.visibility = View.VISIBLE
            binding.txtQuantidadePiaKaw.text = qntPiaKaw.toString()
        } else {
            binding.PiaKaw.visibility = View.GONE
        }

        if (piaTokMostrar){
            binding.PiaTok.visibility = View.VISIBLE
            binding.txtQuantidadePiaTok.text = qntPiaTok.toString()
        } else {
            binding.PiaTok.visibility = View.GONE
        }

        //Configurando botões de adicionar e remover
        binding.btAddClaBb.setOnClickListener {
            qntClaBb = addQuantidade(qntClaBb, valClaBb)
            CarrinhoProdutos.qntClaBb = qntClaBb
            binding.txtQuantidadeClaBb.text = qntClaBb.toString()
        }
        binding.btRemoveClaBb.setOnClickListener {
            if(qntClaBb > 0){
                qntClaBb = removeQuantidade(qntClaBb, valClaBb)
                CarrinhoProdutos.qntClaBb = qntClaBb
            }
            if (qntClaBb == 0){
                qntClaBb = 1
                CarrinhoProdutos.qntClaBb = 1
                AdicionarProduto.claBbMostrar = false
                binding.ClaBb.visibility = View.GONE
            }
            binding.txtQuantidadeClaBb.text = qntClaBb.toString()
        }

        binding.btAddClaEb.setOnClickListener {
            qntClaEb = addQuantidade(qntClaEb, valClaEb)
            CarrinhoProdutos.qntClaEb = qntClaEb
            binding.txtQuantidadeClaEb.text = qntClaEb.toString()
        }
        binding.btRemoveClaEb.setOnClickListener {
            if(qntClaEb > 0){
                qntClaEb = removeQuantidade(qntClaEb, valClaEb)
                CarrinhoProdutos.qntClaEb = qntClaEb
            }
            if (qntClaEb == 0){
                qntClaEb = 1
                CarrinhoProdutos.qntClaEb = 1
                AdicionarProduto.claEbMostrar = false
                binding.ClaEb.visibility = View.GONE
            }
            binding.txtQuantidadeClaEb.text = qntClaEb.toString()
        }

        binding.btAddTromBb.setOnClickListener {
            qntTromBb = addQuantidade(qntTromBb, valTromBb)
            CarrinhoProdutos.qntTromBb = qntTromBb
            binding.txtQuantidadeTromBb.text = qntTromBb.toString()
        }
        binding.btRemoveTromBb.setOnClickListener {
            if(qntTromBb > 0){
                qntTromBb = removeQuantidade(qntTromBb, valTromBb)
                CarrinhoProdutos.qntTromBb = qntTromBb
            }
            if (qntTromBb == 0){
                qntTromBb = 1
                CarrinhoProdutos.qntTromBb = 1
                AdicionarProduto.tromBbMostrar = false
                binding.TromBb.visibility = View.GONE
            }
            binding.txtQuantidadeTromBb.text = qntTromBb.toString()
        }

        binding.btAddTromC.setOnClickListener {
            qntTromC = addQuantidade(qntTromC, valTromC)
            CarrinhoProdutos.qntTromC = qntTromC
            binding.txtQuantidadeTromC.text = qntTromC.toString()
        }
        binding.btRemoveTromC.setOnClickListener {
            if(qntTromC > 0){
                qntTromC = removeQuantidade(qntTromC, valTromC)
                CarrinhoProdutos.qntTromC = qntTromC
            }
            if (qntTromC == 0){
                qntTromC = 1
                CarrinhoProdutos.qntTromC = 1
                AdicionarProduto.tromCMostrar = false
                binding.TromC.visibility = View.GONE
            }
            binding.txtQuantidadeTromC.text = qntTromC.toString()
        }

        binding.btAddSaxAlto.setOnClickListener {
            qntSaxAlto = addQuantidade(qntSaxAlto, valSaxAlto)
            CarrinhoProdutos.qntSaxAlto =qntSaxAlto
            binding.txtQuantidadeSaxAlto.text = qntSaxAlto.toString()
        }
        binding.btRemoveSaxAlto.setOnClickListener {
            if(qntSaxAlto > 0){
                qntSaxAlto = removeQuantidade(qntSaxAlto, valSaxAlto)
                CarrinhoProdutos.qntSaxAlto = qntSaxAlto
            }
            if (qntSaxAlto == 0){
                qntSaxAlto = 1
                CarrinhoProdutos.qntSaxAlto = 1
                AdicionarProduto.saxAltoMostrar = false
                binding.SaxAlto.visibility = View.GONE
            }
            binding.txtQuantidadeSaxAlto.text = qntSaxAlto.toString()
        }

        binding.btAddSaxTenor.setOnClickListener {
            qntSaxTenor = addQuantidade(qntSaxTenor, valSaxTenor)
            CarrinhoProdutos.qntSaxTenor = qntSaxTenor
            binding.txtQuantidadeSaxTenor.text = qntSaxTenor.toString()
        }
        binding.btRemoveSaxTenor.setOnClickListener {
            if(qntSaxTenor > 0){
                qntSaxTenor = removeQuantidade(qntSaxTenor, valSaxTenor)
                CarrinhoProdutos.qntSaxTenor = qntSaxTenor
            }
            if (qntSaxTenor == 0){
                qntSaxTenor = 1
                CarrinhoProdutos.qntSaxTenor = 1
                AdicionarProduto.saxTenorMostrar = false
                binding.SaxTenor.visibility = View.GONE
            }
            binding.txtQuantidadeSaxTenor.text = qntSaxTenor.toString()
        }

        binding.btAddVioRol.setOnClickListener {
            qntVioRol = addQuantidade(qntVioRol, valVioRol)
            CarrinhoProdutos.qntVioRol = qntVioRol
            binding.txtQuantidadeVioRol.text = qntVioRol.toString()
        }
        binding.btRemoveVioRol.setOnClickListener {
            if(qntVioRol > 0){
                qntVioRol = removeQuantidade(qntVioRol, valVioRol)
                CarrinhoProdutos.qntVioRol = qntVioRol
            }
            if (qntVioRol == 0){
                qntVioRol = 1
                CarrinhoProdutos.qntVioRol = 1
                AdicionarProduto.vioRolMostrar = false
                binding.VioRol.visibility = View.GONE
            }
            binding.txtQuantidadeVioRol.text = qntVioRol.toString()
        }

        binding.btAddVioLut.setOnClickListener {
            qntVioLut = addQuantidade(qntVioLut, valVioLut)
            CarrinhoProdutos.qntVioLut = qntVioLut
            binding.txtQuantidadeVioLut.text = qntVioLut.toString()
        }
        binding.btRemoveVioLut.setOnClickListener {
            if(qntVioLut > 0){
                qntVioLut = removeQuantidade(qntVioLut, valVioLut)
                CarrinhoProdutos.qntVioLut = qntVioLut
            }
            if (qntVioLut == 0){
                qntVioLut = 1
                CarrinhoProdutos.qntVioLut = 1
                AdicionarProduto.vioLutMostrar = false
                binding.VioLut.visibility = View.GONE
            }
            binding.txtQuantidadeVioLut.text = qntVioLut.toString()
        }

        binding.btAddPiaKaw.setOnClickListener {
            qntPiaKaw = addQuantidade(qntPiaKaw, valPiaKaw)
            CarrinhoProdutos.qntPiaKaw = qntPiaKaw
            binding.txtQuantidadePiaKaw.text = qntPiaKaw.toString()
        }
        binding.btRemovePiaKaw.setOnClickListener {
            if(qntPiaKaw > 0){
                qntPiaKaw = removeQuantidade(qntPiaKaw, valPiaKaw)
                CarrinhoProdutos.qntPiaKaw = qntPiaKaw
            }
            if (qntPiaKaw == 0){
                qntPiaKaw = 1
                CarrinhoProdutos.qntPiaKaw = 1
                AdicionarProduto.piaKawMostrar = false
                binding.PiaKaw.visibility = View.GONE
            }
            binding.txtQuantidadePiaKaw.text = qntPiaKaw.toString()
        }

        binding.btAddPiaTok.setOnClickListener {
            qntPiaTok = addQuantidade(qntPiaTok, valPiaTok)
            CarrinhoProdutos.qntPiaTok = qntPiaTok
            binding.txtQuantidadePiaTok.text = qntPiaTok.toString()
        }
        binding.btRemovePiaTok.setOnClickListener {
            if(qntPiaTok > 0){
                qntPiaTok = removeQuantidade(qntPiaTok, valPiaTok)
                CarrinhoProdutos.qntPiaTok = qntPiaTok
            }
            if (qntPiaTok == 0){
                qntPiaTok = 1
                CarrinhoProdutos.qntPiaTok = 1
                AdicionarProduto.piaTokMostrar = false
                binding.PiaTok.visibility = View.GONE
            }
            binding.txtQuantidadePiaTok.text = qntPiaTok.toString()
        }

        //Configurando botões de pagamento e voltar(homeup)
        binding.btEfetuarPagamento.setOnClickListener {
            Toast.makeText(this, "Pagamento realizado com sucesso", Toast.LENGTH_LONG).show()
            ResetarDados()
        }

        binding.btVoltar.setOnClickListener {
            finish()
        }

        binding.txtValorTotal.text = String.format("R$ %.2f", valorTotal)
    }

    private fun addQuantidade(quantidade: Int, valor: Float): Int{
        var quant = quantidade
        quant += 1
        addValor(valor)
        return quant
    }

    private fun removeQuantidade(quantidade: Int, valor: Float): Int{
        var quant = quantidade
        quant -= 1
        removeValor(valor)
        return quant
    }

    private fun addValor(valor: Float){
        var valor: Float = valor
        var total: Float = valorTotal
        total += valor
        valorTotal = total
        CarrinhoProdutos.valortotal = valorTotal
        binding.txtValorTotal.text = String.format("R$ %.2f", valorTotal)
    }

    private fun removeValor(valor: Float){
        val valor = valor
        var total = valorTotal
        total -= valor
        valorTotal = total
        CarrinhoProdutos.valortotal = valorTotal
        binding.txtValorTotal.text = String.format("R$ %.2f", valorTotal)
    }

    private fun ResetarDados(){
        AdicionarProduto.claBbMostrar = false
        AdicionarProduto.claEbMostrar = false
        AdicionarProduto.tromBbMostrar = false
        AdicionarProduto.tromCMostrar = false
        AdicionarProduto.saxAltoMostrar = false
        AdicionarProduto.saxTenorMostrar = false
        AdicionarProduto.vioRolMostrar = false
        AdicionarProduto.vioLutMostrar = false
        AdicionarProduto.piaKawMostrar = false
        AdicionarProduto.piaTokMostrar = false

        binding.ClaBb.visibility = View.GONE
        binding.ClaEb.visibility = View.GONE
        binding.TromBb.visibility = View.GONE
        binding.TromC.visibility = View.GONE
        binding.SaxAlto.visibility = View.GONE
        binding.SaxTenor.visibility = View.GONE
        binding.VioRol.visibility = View.GONE
        binding.VioLut.visibility = View.GONE
        binding.PiaKaw.visibility = View.GONE
        binding.PiaTok.visibility = View.GONE

        valorTotal = 0f
        CarrinhoProdutos.valortotal = valorTotal

        qntClaBb = 1
        qntClaEb = 1
        qntTromBb = 1
        qntTromC = 1
        qntSaxAlto = 1
        qntSaxTenor = 1
        qntVioRol = 1
        qntVioLut = 1
        qntPiaKaw = 1
        qntPiaTok = 1

        binding.txtValorTotal.text = String.format("R$ %.2f", valorTotal)
    }
}