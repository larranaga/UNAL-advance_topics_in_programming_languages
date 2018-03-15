import os

directories = ['0', '1', '2', '3', '4']
test_cases = {'0':2,'1': 5,'2': 4,'3': 4,'4': 4}

for directory in directories:
    for i in range(1, test_cases[directory] + 1):
        command = 'diff --strip-trailing-cr ' + str(directory) + '/' + 'm_out' + str(directory) + str(i) + '.txt ' + str(directory) + '/' + 'out' + str(directory) + str(i) + '.txt '
        print(command)
        os.system(command)