const API_URL="http://localhost:8080/api/telemetry";
document.addEventListener("DOMContentLoaded",()=>{
fetchJobs();
document.getElementById("jobForm").addEventListener("submit",async(e)=>{
e.preventDefault();
const data={
jobName:document.getElementById("jobName").value,
status:document.getElementById("status").value,
logOutput:document.getElementById("logOutput").value
};
await fetch(API_URL,{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(data)
});
document.getElementById("jobForm").reset();
setTimeout(fetchJobs,500);
});
});
async function fetchJobs(){
const res=await fetch(API_URL);
const jobs=await res.json();
const tbody=document.querySelector("#jobTable tbody");
tbody.innerHTML="";
jobs.forEach(job=>{
const tr=document.createElement("tr");
tr.innerHTML=`<td>${job.id}</td><td>${job.jobName}</td><td>${job.status}</td><td>${job.riskLevel}</td><td>${job.aiAnalysis}</td>`;
tbody.appendChild(tr);
});
}