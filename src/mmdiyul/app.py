from twitter import Twitter
import time

tw = Twitter()

def start():
    print("Starting program...")
    dms = list()
    while True:
        count = 0
        if len(dms) is not 0:
            if count < 3:
                for i in range(len(dms)):
                    message = dms[i]['message']
                    sender_id = dms[i]['sender_id']
                    id = dms[i]['id']
                    lowerMessage = message.lower()

                    if len(message) is not 0 and len(message) < 280:
                        if "pfess" in lowerMessage or "mrcloud" in lowerMessage or "hayo!" in lowerMessage:
                            count = count + 1
                            if len(message) is not 0:
                                if dms[i]['media'] is None:
                                    print("DM will be posted")
                                    tw.post_tweet(message)
                                    tw.delete_dm(id)
                                else:
                                    print("DM will be posted with media")
                                    print(dms[i]['shorted_media_url'])
                                    tw.post_tweet_with_media(message, dms[i]['media'],dms[i]['shorted_media_url'])
                                    tw.delete_dm(id)

                        else:
                            print("DM will be deleted because does not contains keyword..")
                            tw.delete_dm(id)

                dms = list()

        else:
            print("Direct message is empty...")
            time.sleep(70)
            dms = tw.read_dm()

if __name__ == "__main__":
    start()