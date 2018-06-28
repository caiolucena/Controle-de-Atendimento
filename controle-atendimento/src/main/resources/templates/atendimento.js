var Atendimento = Atendimento ||{}
var $ = jQuery;

Atendimento.MaskMoney = (function(){
	function MaskMoney(){
		this.decimal =  $('.js-decimal');
		this.plain = $('.js-plain');
	}
	MaskMoney.prototype.enable = function(){
		this.decimal.maskMoney({thousands:'.', decimal:','}); //
		this.plain.maskMoney({precision:0,thousands:"."});
	}
	return MaskMoney;
}());

Atendimento.MaskPhoneNumber = (function() {
	
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	
	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputPhoneNumber.mask(maskBehavior, options);
	}
	
	return MaskPhoneNumber;
	
}());

Atendimento.MaskCpf = (function(){

	function MaskCpf(){
		this.inputCpf = $('.js-cpf');
	}
	MaskCpf.prototype.enable = function(){
		this.inputCpf.mask('000.000.000-00', {reverse: true});
		
	}
	
	return MaskCpf;
}());

Atendimento.MaskCfop = (function(){

	function MaskCfop(){
		this.inputCfop = $('.js-cfop');
	}
	MaskCfop.prototype.enable = function(){
		this.inputCfop.mask('0.000', {reverse: true});
		
	}
	
	return MaskCfop;
}());

Atendimento.MaskNcm = (function(){

	function MaskNcm(){
		this.inputNcm = $('.js-ncm');
	}
	MaskNcm.prototype.enable = function(){
		this.inputNcm.mask('00000000', {reverse: true});
		
	}
	
	return MaskNcm;
}());

Atendimento.MaskCest = (function(){

	function MaskCest(){
		this.inputCest = $('.js-cest');
	}
	MaskCest.prototype.enable = function(){
		this.inputCest.mask('0000000', {reverse: true});
		
	}
	
	return MaskCest;
}());

Atendimento.MaskIcms = (function(){

	function MaskIcms(){
		this.inputIcms = $('.js-icms');
	}
	MaskIcms.prototype.enable = function(){
		this.inputIcms.mask('000', {reverse: true});
		
	}
	
	return MaskIcms;
}());

Atendimento.MaskCnpj = (function(){

	function MaskCnpj(){
		this.inputCnpj = $('.js-cnpj');
	}
	MaskCnpj.prototype.enable = function(){
		this.inputCnpj.mask('000.000.000/0000-00', {reverse: true});
		
	}
	
	return MaskCnpj;
}());

Atendimento.MaskCep = (function() {
	
	function MaskCep() {
		this.inputCep = $('.js-cep');
	}
	
	MaskCep.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}
	
	return MaskCep;
	
}());



$(function(){

		var maskMoney = new Atendimento.MaskMoney();
		maskMoney.enable();
		
		var maskPhoneNumber = new Atendimento.MaskPhoneNumber();
		maskPhoneNumber.enable();
		
		var maskCpf = new Atendimento.MaskCpf();
		maskCpf.enable();
		
		var maskCep = new Atendimento.MaskCep();
		maskCep.enable();
		
		var maskCnpj = new Atendimento.MaskCnpj();
		maskCnpj.enable();
		
		var maskCfop = new Atendimento.MaskCfop();
		maskCfop.enable();
		
		var maskNcm = new Atendimento.MaskNcm();
		maskNcm.enable();
		
		var maskCest = new Atendimento.MaskCest();
		maskCest.enable();
		
		var maskIcms = new Atendimento.MaskIcms();
		maskIcms.enable();
		
		
});