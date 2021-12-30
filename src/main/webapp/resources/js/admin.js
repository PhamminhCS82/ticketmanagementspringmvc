



function generateColor(){
    let r =parseInt(Math.random()*255);
    let g =parseInt(Math.random()*255);
    let b =parseInt(Math.random()*255);
    
    return `rgb(${r}, ${g}, ${b})`;
}

function cateChart(id,cateLabels=[], cateinfo =[]){
    let colors = []
    for(let i = 0; i<cateinfo.length ; i++)
        colors.push(generateColor());
    const labels = Utils.months({count: 7});
const data = {
  labels: cateLabels=[],
  datasets: [{
    label: 'Thống kê theo chuyến',
    data: cateinfo =[],
    backgroundColor: colors,
    borderColor: [
      'rgb(255, 99, 132)',
      'rgb(255, 159, 64)',
      'rgb(255, 205, 86)',
      'rgb(75, 192, 192)',
      'rgb(54, 162, 235)',
      'rgb(153, 102, 255)',
      'rgb(201, 203, 207)'
    ],
    borderWidth: 1
  }]
};
    const config = {
  type: 'bar',
  data: data,
  options: {
    scales: {
      y: {
        beginAtZero: true
      }
    }
  },
};
 let c = document.getElementById(id).getContext("2d");
    new Chart(c, config);
}

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
