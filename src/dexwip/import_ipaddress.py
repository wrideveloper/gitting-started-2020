import os
import ipaddress


def main():
    source = open(os.path.join(os.getcwd(), 'hosts'), "r")
    destination = open(os.path.join(os.getcwd(), 'importdns.rsc'), "w")
    destination.write("/ip dns static\n")
    with source as dataRaw:
        for line in dataRaw:
            if not line.startswith("#") and not line.startswith("\n"):
                line = line.strip().split()

                try:
                    ipaddress.ip_address(line[0])
                except ValueError:
                    print("ip address: '{}' is not valid".format(line[0]))
                    break
                for i in range((len(line)-1)):
                    destination.write(
                        "add name={} address={}\n".format(line[i+1], line[0]))
    source.close()
    destination.close()


if __name__ == "__main__":
    main()
