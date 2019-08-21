@suite
Feature: Pesquisa no Google

  Scenario Outline: Pesquisa no Google

	Given acesso o site do google
	And digito "<pesquisa>" na barra de Pesquisa
	And clico no botao Pesquisar
	Then valido a mensagem "<mensagem>"
	
	Examples: 
	| pesquisa |mensagem		|
	| google   |Aproximadamente |
	| google2   |Aproximadamente |