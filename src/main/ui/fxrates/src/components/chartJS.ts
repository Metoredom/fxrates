export const dataChart = {
  labels: [],
  datasets: [
    {
      label: 'Rate',
      borderColor: "rgb(11, 83, 148)",
      backgroundColor: "rgba(11, 83, 148, 0.9)",
      data: [],
      fill: false,
      tension: 0.1
    }
  ]
}



export const optionsChart = {
  responsive: true,
  maintainAspectRatio: false,
  legend: {
    display: false
  },
  scales: {
    x: {
      display: false,
      title: {
        display: true
      }
    },
    y: {
      display: true,
      title: {
        display: true,
        text: 'Value'
      },
    }
  },
  elements: {
    point: {
      pointStyle: false
    }
  }
}
