///* globals Chart:false, feather:false */
//
//(function () {
//  'use strict'
//
//  feather.replace()
//
//  // Graphs
//  var ctx = document.getElementById('myChart')
//  // eslint-disable-next-line no-unused-vars
//  var myChart = new Chart(ctx, {
//    type: 'line',
//    data: {
//      labels: [
//        'Sunday',
//        'Monday',
//        'Tuesday',
//        'Wednesday',
//        'Thursday',
//        'Friday',
//        'Saturday'
//      ],
//      datasets: [{
//        data: [
//          15339,
//          21345,
//          18483,
//          24003,
//          23489,
//          24092,
//          12034
//        ],
//        lineTension: 0,
//        backgroundColor: 'transparent',
//        borderColor: '#007bff',
//        borderWidth: 4,
//        pointBackgroundColor: '#007bff'
//      }]
//    },
//    options: {
//      scales: {
//        yAxes: [{
//          ticks: {
//            beginAtZero: false
//          }
//        }]
//      },
//      legend: {
//        display: false
//      }
//    }
//  })
//})()
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
 labels: cateLabels=[],
  datasets: [{
    label: 'Thống kê doanh thu theo tháng',
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
 let c = document.getElementById(id).getContext("2d")
    new Chart(c, config)
}