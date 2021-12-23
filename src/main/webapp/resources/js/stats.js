/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function generateColor(){
    let r =parseInt(Math.random()*255);
    let g =parseInt(Math.random()*255);
    let b =parseInt(Math.random()*255);
    
    return `rgb(${r}, ${g}, ${b})`
}
function cateChart(id,cateLabels=[], cateinfo =[]){
    let colors = []
    for(let i = 0; i<cateinfo.length ; i++)
        colors.push(generateColor())
    
const data = {
  labels: cateLabels,
  datasets: [{
    label: 'My First Dataset',
    data: cateinfo,
    backgroundColor: colors,
  }]
};
    const config = {
  type: 'line',
  data: data,
 
};
 let c = document.getElementById(id).getContext("2d")
    new Chart(c, config)
}
