<script lang="ts">
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js'
import { Line } from 'vue-chartjs'
import * as chartConfig from './chartJS.ts'
import { formatDate } from './utils'

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
)

export default {
  name: 'RateChart',
  components: {
    Line
  },
  props: {
    'data': [Object],
  },
  methods: {
    prepareData(){
      this.chartConfig.dataChart.labels = this.data.map(el => formatDate(el.date)).reverse()
      this.chartConfig.dataChart.datasets[0].data = this.data.map(el => el.rate).reverse()
    }
  },
  computed: {
    chartData() { return this.chartConfig.dataChart },
    chartOptions() { return this.chartConfig.optionsChart }
  },
  data() {
    return {
      chartConfig,
      chart: false
    }
  },
  mounted() {
    this.prepareData()
    this.chart = true
  }
}

</script>
<template>
  <Line v-if="chart" :data="chartData" :options="chartOptions" />
</template>