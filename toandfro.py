from sys import stdin

def create_parts(s, l):
  while(s):
    yield list(s[:l])
    s = s[l:]

def reverse_alternate(s, l):
  reverse = []
  for (i, parts) in enumerate(create_parts(s, l)):
    if i % 2 != 0: 
      parts.reverse()
    reverse.append(parts)
  return reverse

def decrypt_list(ll):
  column_count = len(ll[0])
  message_list = []
  for i in range(column_count):
    for l in ll:
      message_list.append(l[i])
  decrypted = ''.join(message_list)
  return decrypted


def main():
  eof = False
  while not eof:
    column_count = int(stdin.readline())
    if column_count == 0:
      eof = True
    else:
      encrypted_message = stdin.readline().strip()
      ll = reverse_alternate(encrypted_message, column_count)
      decrypted = decrypt_list(ll)
      print decrypted

if __name__ == '__main__':
  main()
