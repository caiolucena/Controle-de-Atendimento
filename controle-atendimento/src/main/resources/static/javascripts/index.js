var $ = jQuery;
function selecionouEstado(id, url) {
	$.ajax({
		url : url,
		method : 'POST',
		contentType : 'application/json',
		data : JSON.stringify({
			id : id
		}),
		error : erroEstado,
		success : selecionarCidade
	});

	function selecionarCidade(cidades) {
		var comboCidade = $("#cidade");
		comboCidade
				.html('<option value =' + 0 + '>Selecione a Cidade</option>');

		for ( var i in cidades) {
			comboCidade.append('<option value =' + cidades[i].id + '>'
					+ cidades[i].nome + '</option>');
		}

	}
	function erroEstado() {
		console.log('Erro em carregar as cidades!')
	}

}

function usouCheckbox(){
	var radioCadastrado = $("#clienteCadastrado");
	var radioNaoCadastrado = $("#clienteNaoCadastrado");
	var codigo = $("#codigoCliente");
	var nome = $("#nomeCliente");

	if(radioCadastrado.prop("checked")){

		codigo.prop('readonly',false);
		nome.prop('readonly',true);
		nome.val('');
		codigo.val('');
		codigo.focus();
	}
	
	else if(radioNaoCadastrado.prop("checked")){

		nome.val('PROSPECÇÃO - Insira o nome do cliente aqui');
		nome.focus();
		codigo.val(0);
		codigo.prop('readonly',true);	
		nome.prop('readonly',false);
	}
}


function selecionouCliente(id, url) {
	$.ajax({
		url : url,
		method : 'POST',
		contentType : 'application/json',
		data : JSON.stringify({
			id : id
		}),
		error : erroCliente,
		success : alterarCliente
	});

	function alterarCliente(cliente) {
		console.log("Nao deu erro aqui");
		var nomeCliente = $("#nomeCliente");
		if(cliente){
			nomeCliente.val(cliente.nome);	
		}
		else{
			nomeCliente.val("Não há cliente cadastrado com o código informado");
		}
		
	}
	function erroCliente() {
		var nomeCliente = $("#nomeCliente");
	
		nomeCliente.val("Não há cliente cadastrado com o código informado");
	}

}
