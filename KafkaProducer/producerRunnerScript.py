import  os, sys
import subprocess

class Runner:
	def runScript(self):
	startScript=os.getCmd()+"/KafkaProducer/producerScript.sh";
	exe_cmd("sh",startScript);

	def exe_cmd(cmd, ignoreError="false"):
	print "cmd to be executed "+cmd;
	p=subProcess.Popen(cmd, shell=true,stderr=subprocess.PIPE);
	print "cmd file start reading";
  	while True:
	    print "reading file ";
	    out=p.stderr.read(1);
	    if(out== '' and p.poll()!=None:
		print "getting "+ str(p.returncode)+ ignoreError;
		if(ignoreError =='false' and p.returncode !=0):
		print "[CMD_ERROR] +cmd;
		break;
		sys.exit("[CMD_Execution_FAIL]: "+cmd);
	    if out !='':
		sys.stdout.write(out);
		sys.stdout.flush;

	
