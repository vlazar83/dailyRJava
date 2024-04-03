import requests
from lxml import html
from datetime import datetime, timedelta

# Function to extract content from the specified URL using XPath
def extract_content(url):
    response = requests.get(url)
    tree = html.fromstring(response.content)
    
    # Extract content using XPath
    first_content_element = tree.xpath('//*[@id="page#6"]/p[1]')[0]
    first_content = first_content_element.text_content().strip()
    first_link = first_content_element.xpath('./a')[0].text.strip()
    first_link_url = first_content_element.xpath('./a/@href')[0]

    second_content_element = tree.xpath('//*[@id="page#6"]/p[2]')[0]
    second_content = second_content_element.text_content().strip()
    second_link = second_content_element.xpath('./a')[0].text.strip()
    second_link_url = second_content_element.xpath('./a/@href')[0]

    return first_content, first_link, first_link_url, second_content, second_link, second_link_url

# Function to generate SQL insert statements
def generate_insert_sql(content1, link1, link1_url, content2, link2, link2_url, date):
    insert_sql = "INSERT INTO readings (reading_year, reading_month, reading_day, firstreading, firstreading_short, firstreading_link, secondreading, secondreading_short, secondreading_link, created_by) VALUES "
    insert_sql += "('{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', '{}', 'admin');".format(date.year, date.strftime('%m'), date.day, content1, link1, link1_url, content2, link2, link2_url)
    
    return insert_sql

# Main function
def main():
    base_url = "https://www.evangelikus.hu/hitunk/lelki-taplalek?napiigenap={}"
    start_date = datetime(2024, 1, 1)
    end_date = datetime(2024, 3, 31)
    
    output_file = "output3.sql"  # Name of the output file
    
    with open(output_file, 'w') as f:
        current_date = start_date
        while current_date <= end_date:
            url = base_url.format(current_date.strftime('%Y-%m-%d'))
            content1, link1, link1_url, content2, link2, link2_url = extract_content(url)
            insert_sql = generate_insert_sql(content1, link1, link1_url, content2, link2, link2_url, current_date)
            
            # Write SQL insert statement to the output file
            f.write(insert_sql + '\n')
            
            # Move to the next date
            current_date += timedelta(days=1)

if __name__ == "__main__":
    main()