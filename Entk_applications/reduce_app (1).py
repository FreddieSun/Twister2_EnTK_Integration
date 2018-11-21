from radical.entk import Pipeline, Stage, Task, AppManager
import os

# ------------------------------------------------------------------------------
# Set default verbosity

if os.environ.get('RADICAL_ENTK_VERBOSE') == None:
    os.environ['RADICAL_ENTK_REPORT'] = 'True'

# Description of how the RabbitMQ process is accessible
# No need to change/set any variables if you installed RabbitMQ has a system
# process. If you are running RabbitMQ under a docker container or another
# VM, set "RMQ_HOSTNAME" and "RMQ_PORT" in the session where you are running
# this script.
hostname = os.environ.get('RMQ_HOSTNAME', 'localhost')
port = os.environ.get('RMQ_PORT', 5672)

if __name__ == '__main__':

    # Create a Pipeline object
    p = Pipeline()
    p.name ='Pipeline 1'

    # Create a Stage object
    s1 = Stage()
    s1.name = 'Stage 1'

    # Create a Task object
    t1 = Task()
    t1.name = 'Generator 1'        # Assign a name to the task (optional, do not use ',' or '_')
    t1.executable = ['python3']   # Assign executable to the task
    t1.arguments = ['/home/divyaprakash/EnTK/share/radical.entk/user_guide/scripts/generator1.py', '10']  # Assign arguments for the task executable

    # Create a Task object
    t2 = Task()
    t2.name = 'Generator 2'  # Assign a name to the task (optional, do not use ',' or '_')
    t2.executable = ['python3']  # Assign executable to the task
    t2.arguments = ['/home/divyaprakash/EnTK/share/radical.entk/user_guide/scripts/generator2.py', '10']  # Assign arguments for the task executable

    # Create a Task object
    t3 = Task()
    t3.name = 'Generator 3'  # Assign a name to the task (optional, do not use ',' or '_')
    t3.executable = ['python3']  # Assign executable to the task
    t3.arguments = ['/home/divyaprakash/EnTK/share/radical.entk/user_guide/scripts/generator3.py', '10']  # Assign arguments for the task executable

    # Add Task to the Stage
    s1.add_tasks(t1)
    s1.add_tasks(t2)
    s1.add_tasks(t3)

    p.add_stages(s1)

    s2 = Stage()

    # Create a Task object
    t4 = Task()
    t4.name = 'Compute 1'  # Assign a name to the task (optional, do not use ',' or '_')
    # Copy data from the task in the first stage to the current task's location
    t4.copy_input_data = ['$Pipeline_%s_Stage_%s_Task_%s/output1.txt' % ('Pipeline 1', 'Stage 1', 'Generator 1')]
    t4.executable = ['python3']  # Assign executable to the task
    t4.arguments = ['/home/divyaprakash/EnTK/share/radical.entk/user_guide/scripts/compute.py', 'output1.txt']  # Assign arguments for the task executable
    

    # Create a Task object
    t5 = Task()
    t5.name = 'Compute 2'  # Assign a name to the task (optional, do not use ',' or '_')
    # Copy data from the task in the first stage to the current task's location
    t5.copy_input_data = ['$Pipeline_%s_Stage_%s_Task_%s/output2.txt' % ('Pipeline 1', 'Stage 1', 'Generator 2')]
    t5.executable = ['python3']  # Assign executable to the task
    t5.arguments = ['/home/divyaprakash/EnTK/share/radical.entk/user_guide/scripts/compute.py', 'output2.txt']  # Assign arguments for the task executable
    
    # Create a Task object
    t6 = Task()
    t6.name = 'Compute 3'  # Assign a name to the task (optional, do not use ',' or '_')
    # Copy data from the task in the first stage to the current task's location
    t6.copy_input_data = ['$Pipeline_%s_Stage_%s_Task_%s/output3.txt' % ('Pipeline 1', 'Stage 1', 'Generator 3')]
    t6.executable = ['python3']  # Assign executable to the task
    t6.arguments = ['/home/divyaprakash/EnTK/share/radical.entk/user_guide/scripts/compute.py', 'output3.txt']  # Assign arguments for the task executable
    

    # Add Task to the Stage
    s2.add_tasks(t4)
    s2.add_tasks(t5)
    s2.add_tasks(t6)
    # Add Stage to the Pipeline
    
    p.add_stages(s2)

    # Create Application Manager
    appman = AppManager(hostname=hostname, port=port)

    # Assign the workflow as a set or list of Pipelines to the Application Manager
    # Note: The list order is not guaranteed to be preserved
    appman.workflow = set([p])

    # Create a dictionary describe four mandatory keys:
    # resource, walltime, and cpus
    # resource is 'local.localhost' to execute locally
    res_dict = {

        'resource': 'local.localhost',
        'walltime': 10,
        'cpus': 1
    }

    # Assign resource request description to the Application Manager
    appman.resource_desc = res_dict


    # Run the Application Manager
    appman.run()
