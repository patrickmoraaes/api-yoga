const API_BASE_URL = 'https://yoga-api-nzy4.onrender.com/v1';

async function fetchPoses() {
  const response = await fetch(`${API_BASE_URL}/categories?id=3`); 
  const data = await response.json();
  return data.poses;
}

let poses = [];
let currentPoseIndex = 0;
let timer;
let timerCount = 30;

document.addEventListener('DOMContentLoaded', async () => {
  poses = await fetchPoses();
  loadPose(currentPoseIndex);

  document.getElementById('prev-button').addEventListener('click', prevPose);
  document.getElementById('play-button').addEventListener('click', startTimer);
  document.getElementById('next-button').addEventListener('click', nextPose);
});

function loadPose(index) {
  const pose = poses[index];
  console.log('Loading pose:', pose);
  document.getElementById('pose-name').textContent = pose.english_name;
  document.getElementById('pose-image').src = pose.url_png;
  document.getElementById('pose-index').textContent = index + 1;
  document.getElementById('total-poses').textContent = poses.length;
  resetTimer();
}

function prevPose() {
  if (currentPoseIndex > 0) {
    currentPoseIndex--;
    loadPose(currentPoseIndex);
    console.log('Previous pose:', currentPoseIndex);
  } else {
    console.log('No previous pose.');
  }
}

function nextPose() {
  if (currentPoseIndex < poses.length - 1) {
    currentPoseIndex++;
    loadPose(currentPoseIndex);
    console.log('Next pose:', currentPoseIndex);
  } else {
    console.log('No next pose.');
  }
}

function startTimer() {
  timerCount = 30;
  updateTimer();
  timer = setInterval(() => {
    timerCount--;
    updateTimer();
    if (timerCount <= 0) {
      clearInterval(timer);
      nextPose();
      startTimer();
    }
  }, 1000);
  console.log('Timer started');
}

function resetTimer() {
  clearInterval(timer);
  timerCount = 30;
  updateTimer();
  console.log('Timer reset');
}

function updateTimer() {
  document.getElementById('timer-count').textContent = timerCount;
  document.querySelector('.timer-text').textContent = `00:${timerCount < 10 ? '0' : ''}${timerCount}`;
  console.log('Timer updated:', timerCount);
}
