from random import randint

i=0

my_file = open('parsels.csv', 'w')

while i <= 1000000:
    my_file.write('0, 10'+ str(randint(0, 9))+'0' + str(randint(0, 99)) + ', 65'+ str(randint(0, 9))+'3' + str(randint(10, 99)) + ', 63'+ str(randint(0, 9))+'8' + str(randint(10, 60)) + ',' + str(randint(1, 800)) + ', ' + str(randint(1, 1200)) + '' + "\n")
    i+=1
    
my_file.close()
