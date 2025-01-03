function mudarCor(){
    var botao= event.target;
    
    if(botao.style.backgroundColor=="yellow"){
        botao.style.backgroundColor="gray";
    }
    else{
        botao.style.backgroundColor="yellow"
    }
}