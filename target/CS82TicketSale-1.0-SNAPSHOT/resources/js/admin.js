function generateColor(){
    let r =parseInt(Math.random()*255);
    let g =parseInt(Math.random()*255);
    let b =parseInt(Math.random()*255);
    
    return `rgb(${r}, ${g}, ${b})`
}
function MothChart(id,cateLabels=[], cateinfo =[]){
    let colors = []
    for(let i = 0; i<cateinfo.length ; i++)
        colors.push(generateColor())
    
const data = {
  labels: cateLabels,
  datasets: [{
    label: 'Tổng số chuyến của tuyến',
    data: cateinfo,
    backgroundColor: colors,
  }]
};
    const config = {
  type: 'bar',
  data: data,
 
};
 let c = document.getElementById(id).getContext("2d")
    new Chart(c, config)
}
